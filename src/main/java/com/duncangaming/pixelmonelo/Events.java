package com.duncangaming.pixelmonelo;

import com.pixelmonmod.pixelmon.api.events.battles.AttackEvents;
import com.pixelmonmod.pixelmon.api.events.battles.BattleEndEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.PokemonStorage;
import com.pixelmonmod.pixelmon.battles.controller.participants.PixelmonWrapper;
import com.pixelmonmod.pixelmon.battles.controller.participants.TrainerParticipant;
import com.pixelmonmod.pixelmon.enums.battle.BattleResults;
import ibxm.Player;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import scala.reflect.internal.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Events {

    HashMap<UUID, Integer> wins = new HashMap<UUID, Integer>();
    HashMap<UUID, Integer> losses = new HashMap<UUID, Integer>();

    public HashMap<UUID, Integer> getLosses() {
        return losses;
    }

    public HashMap<UUID, Integer> getWins() {
        return wins;
    }

    @SubscribeEvent
    public void end(BattleEndEvent event) {
        if (event.bc.playerNumber >= 2) {
            for (int counter = 0; counter < event.getPlayers().size(); counter++) {
                if (event.getPlayers().get(counter) != null) {
                    BattleResults results = event.results.get(event.getPlayers().get(counter));
                    if (results == BattleResults.VICTORY) {

                        Integer onemore = wins.get(event.getPlayers().get(counter)) + 1;
                        wins.put(event.getPlayers().get(counter).getUniqueID(), onemore);

                    }
                    if (results == BattleResults.DEFEAT) {

                        Integer onemore = losses.get(event.getPlayers().get(counter)) + 1;
                        losses.put(event.getPlayers().get(counter).getUniqueID(), onemore);

                    }
                }
            }
        }

    }



}
