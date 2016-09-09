package com.github.u3games.eventengine.events.types.capturetheflag;

import com.github.u3games.eventengine.config.interfaces.EventConfig;
import com.github.u3games.eventengine.config.model.TeamConfig;
import com.github.u3games.eventengine.model.EItemHolder;
import com.github.u3games.eventengine.util.ConvertUtils;
import com.l2jserver.gameserver.model.holders.ItemHolder;

import java.util.ArrayList;
import java.util.List;

public class CTFEventConfig implements EventConfig {

    private boolean enabled;
    private String instanceFile;
    private int flagNpcId;
    private int holderNpcId;
    private List<EItemHolder> winReward;
    private List<EItemHolder> tieReward;
    private List<EItemHolder> participateReward;
    private boolean rewardKillEnabled;
    private List<EItemHolder> rewardKill;
    private boolean rewardPvPKillEnabled;
    private int rewardPvPKill;
    private boolean rewardFameKillEnabled;
    private int rewardFameKill;
    private int pointsConquerFlag;
    private int pointsKill;
    private int countTeam;
    private List<CTFTeamConfig> teams;

    public boolean isEnabled() {
        return enabled;
    }

    public String getInstanceFile() {
        return instanceFile;
    }

    public int getFlagNpcId() {
        return flagNpcId;
    }

    public int getHolderNpcId() {
        return holderNpcId;
    }

    public List<ItemHolder> getWinReward() {
        return ConvertUtils.convertToListItemsHolders(winReward);
    }

    public List<ItemHolder> getTieReward() {
        return ConvertUtils.convertToListItemsHolders(tieReward);
    }

    public List<ItemHolder> getParticipateReward() {
        return ConvertUtils.convertToListItemsHolders(participateReward);
    }

    public boolean isRewardKillEnabled() {
        return rewardKillEnabled;
    }

    public List<ItemHolder> getRewardKill() {
        return ConvertUtils.convertToListItemsHolders(rewardKill);
    }

    public boolean isRewardPvPKillEnabled() {
        return rewardPvPKillEnabled;
    }

    public int getRewardPvPKill() {
        return rewardPvPKill;
    }

    public boolean isRewardFameKillEnabled() {
        return rewardFameKillEnabled;
    }

    public int getRewardFameKill() {
        return rewardFameKill;
    }

    public int getPointsConquerFlag() {
        return pointsConquerFlag;
    }

    public int getPointsKill() {
        return pointsKill;
    }

    public int getCountTeam() {
        return countTeam;
    }

    public List<CTFTeamConfig> getTeams()
    {
        return teams;
    }
}
