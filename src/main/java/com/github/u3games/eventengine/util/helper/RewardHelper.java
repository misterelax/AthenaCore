package com.github.u3games.eventengine.util.helper;

import com.github.u3games.eventengine.enums.ScoreType;
import com.github.u3games.eventengine.events.holders.PlayerHolder;
import com.github.u3games.eventengine.events.holders.TeamHolder;
import com.github.u3games.eventengine.interfaces.ParticipantHolder;
import com.github.u3games.eventengine.util.SortUtils;
import com.l2jserver.gameserver.model.holders.ItemHolder;

import java.util.*;

public class RewardHelper {

    private ScoreType mType;
    private Map<Integer, Position> mPositions = new HashMap<>();
    private List<ParticipantHolder> mParticipants = new ArrayList<>();
    private List<ItemHolder> mGeneralRewards;
    private Map<Integer, List<ParticipantHolder>> mPositionsFilled = new HashMap<>();

    public void addReward(int pos, List<ItemHolder> rewards, List<ItemHolder> tieRewards) {
        mPositions.put(pos - 1, new Position(rewards, tieRewards));
    }

    public void addGeneralReward(List<ItemHolder> rewards) {
        mGeneralRewards = rewards;
    }

    public void addTeams(Collection<TeamHolder> teams) {
        mParticipants.addAll(teams);
    }

    public void setOrderType(ScoreType type) {
        mType = type;
    }

    public void addPlayers(Collection<PlayerHolder> players) {
        mParticipants.addAll(players);
    }

    public void giveRewards() {
        List<List<ParticipantHolder>> participantsOrdered = SortUtils.getOrdered(mParticipants, mType);
        int index = 0;

        for (List<ParticipantHolder> participants : participantsOrdered) {
            List<ItemHolder> rewards;

            mPositionsFilled.put(index + 1, participants);

            if (mPositions.containsKey(index)) {
                Position pos = mPositions.get(index);
                rewards = participants.size() <= 1 ? pos.getRewards() : pos.getTieRewards();
            } else {
                rewards = mGeneralRewards;
            }

            if (rewards != null) {
                for (ParticipantHolder participant : participants) {
                    participant.giveItems(rewards);
                }
            }

            index++;
        }
    }

    public Map<Integer, List<ParticipantHolder>> getPositions() {
        return mPositionsFilled;
    }

    private class Position {

        private final List<ItemHolder> mRewards;
        private final List<ItemHolder> mTieRewards;

        private Position(List<ItemHolder> rewards, List<ItemHolder> tieRewards) {
            mRewards = rewards;
            mTieRewards = tieRewards;
        }

        private List<ItemHolder> getRewards() {
            return mRewards;
        }

        private List<ItemHolder> getTieRewards() {
            return mTieRewards;
        }
    }
}
