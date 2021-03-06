package me.confuser.banmanager.bukkit.listeners;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.util.DiscordUtil;
import me.confuser.banmanager.bukkit.api.events.*;
import me.confuser.banmanager.common.BanManagerPlugin;
import me.confuser.banmanager.common.listeners.CommonDiscordListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class DiscordListener implements Listener {
  private CommonDiscordListener listener;

  public DiscordListener(BanManagerPlugin plugin) {
    this.listener = new CommonDiscordListener(plugin);
  }

  @EventHandler(priority = EventPriority.MONITOR)
  public void notifyOnBan(PlayerBannedEvent event) {
    if (event.isSilent()) return;

    Object[] data = listener.notifyOnBan(event.getBan());

    DiscordUtil.sendMessage(DiscordSRV.getPlugin().getDestinationTextChannelForGameChannelName((String) data[0]), data[1].toString());
  }

  @EventHandler(priority = EventPriority.MONITOR)
  public void notifyOnMute(PlayerMutedEvent event) {
    if (event.isSilent()) return;

    Object[] data = listener.notifyOnMute(event.getMute());

    DiscordUtil.sendMessage(DiscordSRV.getPlugin().getDestinationTextChannelForGameChannelName((String) data[0]), data[1].toString());
  }

  @EventHandler(priority = EventPriority.MONITOR)
  public void notifyOnBan(IpBannedEvent event) {
    if (event.isSilent()) return;

    Object[] data = listener.notifyOnBan(event.getBan());

    DiscordUtil.sendMessage(DiscordSRV.getPlugin().getDestinationTextChannelForGameChannelName((String) data[0]), data[1].toString());
  }

  @EventHandler(priority = EventPriority.MONITOR)
  public void notifyOnKick(PlayerKickedEvent event) {
    if (event.isSilent()) return;

    Object[] data = listener.notifyOnKick(event.getKick());

    DiscordUtil.sendMessage(DiscordSRV.getPlugin().getDestinationTextChannelForGameChannelName((String) data[0]), data[1].toString());
  }

  @EventHandler(priority = EventPriority.MONITOR)
  public void notifyOnWarn(PlayerWarnedEvent event) {
    if (event.isSilent()) return;

    Object[] data = listener.notifyOnWarn(event.getWarning());

    DiscordUtil.sendMessage(DiscordSRV.getPlugin().getDestinationTextChannelForGameChannelName((String) data[0]), data[1].toString());
  }

  @EventHandler(priority = EventPriority.MONITOR)
  public void notifyOnUnban(PlayerUnbanEvent event) {
    Object[] data = listener.notifyOnUnban(event.getBan(), event.getActor(), event.getReason());

    DiscordUtil.sendMessage(DiscordSRV.getPlugin().getDestinationTextChannelForGameChannelName((String) data[0]), data[1].toString());
  }

  @EventHandler(priority = EventPriority.MONITOR)
  public void notifyOnUnban(IpUnbanEvent event) {
    Object[] data = listener.notifyOnUnban(event.getBan(), event.getActor(), event.getReason());

    DiscordUtil.sendMessage(DiscordSRV.getPlugin().getDestinationTextChannelForGameChannelName((String) data[0]), data[1].toString());
  }

  @EventHandler(priority = EventPriority.MONITOR)
  public void notifyOnUnmute(PlayerUnmuteEvent event) {
    Object[] data = listener.notifyOnUnmute(event.getMute(), event.getActor(), event.getReason());

    DiscordUtil.sendMessage(DiscordSRV.getPlugin().getDestinationTextChannelForGameChannelName((String) data[0]), data[1].toString());
  }
}
