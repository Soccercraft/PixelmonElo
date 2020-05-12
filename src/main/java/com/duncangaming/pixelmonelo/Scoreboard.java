package com.duncangaming.pixelmonelo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.IScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class Scoreboard {


    private PixelmonElo pixelmonElo;
    private Events events;


    public Scoreboard(Events events, PixelmonElo pixelmonElo) {
        this.pixelmonElo = pixelmonElo;
        this.events  = events;
    }


    @SubscribeEvent
    public void join(PlayerEvent.PlayerLoggedInEvent e) {

        setScoreboard(e.player);

    }

    @SubscribeEvent
    public void switchWorlds(PlayerEvent.PlayerChangedDimensionEvent e) {

        setScoreboard(e.player);

    }

    public void setScoreboard (EntityPlayer p) {
        World world = p.world;
        net.minecraft.scoreboard.Scoreboard scoreboard = world.getScoreboard();
        Team team = scoreboard.createTeam(p.toString());
        scoreboard.addPlayerToTeam(p.toString(), team.toString());
        ScoreObjective objective = scoreboard.addScoreObjective("Header", IScoreCriteria.DUMMY);
        objective.setDisplayName("Pixelmon Stats");
        Score wins = scoreboard.getOrCreateScore("Wins", objective);
        if (events.wins.get(0) == null) {
            events.wins.put(p.getUniqueID(), 0);
            wins.setScorePoints(events.losses.get(0).intValue());
        }
        if (events.wins.get(0) != null) {
            wins.setScorePoints(events.losses.get(0).intValue());
        }
        Score losses = scoreboard.getOrCreateScore("Losses", objective);
        if (events.losses.get(0) == null) {
            events.losses.put(p.getUniqueID(), 0);
            losses.setScorePoints(events.losses.get(0).intValue());
        }
        if (events.losses.get(0) != null) {
            losses.setScorePoints(events.losses.get(0).intValue());
        }
        scoreboard.setObjectiveInDisplaySlot(1, objective);

    }

}
