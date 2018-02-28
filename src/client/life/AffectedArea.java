package client.life;

import client.character.Char;
import client.character.skills.*;
import client.character.skills.SkillStat;
import client.jobs.Zero;
import client.jobs.adventurer.Archer;
import client.jobs.adventurer.Magician;
import client.jobs.adventurer.Thief;
import client.jobs.cygnus.BlazeWizard;
import client.jobs.legend.Shade;
import client.jobs.sengoku.Kanna;
import enums.MobStat;
import loaders.SkillData;
import util.Rect;

import static client.character.skills.CharacterTemporaryStat.IndieBooster;
import static client.character.skills.CharacterTemporaryStat.IndieDamR;
import static client.character.skills.SkillStat.indieBooster;
import static client.character.skills.SkillStat.indieDamR;
import static client.character.skills.SkillStat.time;

/**
 * Created on 1/6/2018.
 */
public class AffectedArea extends Life {

    private Rect rect;
    private int charID;
    private int skillID;
    private int force;
    private int option;
    private int elemAttr;
    private int idk;
    private byte slv;
    private byte mobOrigin;
    private short delay;
    private boolean flip;

    public AffectedArea(int objectId) {
        super(objectId);
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public int getCharID() {
        return charID;
    }

    public void setCharID(int charID) {
        this.charID = charID;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public int getElemAttr() {
        return elemAttr;
    }

    public void setElemAttr(int elemAttr) {
        this.elemAttr = elemAttr;
    }

    public int getIdk() {
        return idk;
    }

    public void setIdk(int idk) {
        this.idk = idk;
    }

    public byte getSlv() {
        return slv;
    }

    public void setSlv(byte slv) {
        this.slv = slv;
    }

    public byte getMobOrigin() {
        return mobOrigin;
    }

    public void setMobOrigin(byte mobOrigin) {
        this.mobOrigin = mobOrigin;
    }

    public short getDelay() {
        return delay;
    }

    public void setDelay(short delay) {
        this.delay = delay;
    }

    public boolean isFlip() {
        return flip;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }

    public static AffectedArea getAffectedArea(AttackInfo attackInfo) {
        AffectedArea aa = new AffectedArea(-1);
        aa.setSkillID(attackInfo.skillId);
        aa.setSlv(attackInfo.slv);
        aa.setElemAttr(attackInfo.elemAttr);
        aa.setForce(attackInfo.force);
        aa.setOption(attackInfo.option);
        return aa;
    }

    public static AffectedArea getPassiveAA(int skillID, byte slv) {
        AffectedArea aa = new AffectedArea(-1);
        aa.setSkillID(skillID);
        aa.setSlv(slv);

        return aa;
    }

    public void handleMobInside(Mob mob) {
        Char chr = getField().getCharByID(getCharID());
        if(chr == null) {
            return;
        }
        TemporaryStatManager tsm = chr.getTemporaryStatManager();
        int skillID = getSkillID();
        Skill skill = chr.getSkill(getSkillID());
        byte slv = (byte) skill.getCurrentLevel();
        SkillInfo si = SkillData.getSkillInfoById(skillID);
        MobTemporaryStat mts = mob.getTemporaryStat();
        Option o = new Option();
        Option o1 = new Option();
        Option o2 = new Option();
        Option o3 = new Option();
        switch(skillID) {
            case Magician.POISON_MIST:
            case Archer.FLAME_SURGE:
                if(!mts.hasBurnFromSkill(skillID)) {
                    mts.createAndAddBurnedInfo(getCharID(), skill, 1);
                }
                break;
            case Shade.SPIRIT_TRAP:
                o.nOption = 1;
                o.rOption = skillID;
                o.tOption = si.getValue(time, slv);
                mts.addStatOptionsAndBroadcast(MobStat.Stun, o);
                break;
            case Thief.FRAILTY_CURSE:
                o.nOption = si.getValue(SkillStat.y, slv);
                o.rOption = skillID;
                o.tOption = si.getValue(time, slv);
                mts.addStatOptionsAndBroadcast(MobStat.Speed, o);
                o1.nOption = si.getValue(SkillStat.x, slv);
                o1.rOption = skillID;
                o1.tOption = si.getValue(time, slv);
                mts.addStatOptionsAndBroadcast(MobStat.PAD, o);
                mts.addStatOptionsAndBroadcast(MobStat.PDR, o);
                mts.addStatOptionsAndBroadcast(MobStat.MAD, o);
                mts.addStatOptionsAndBroadcast(MobStat.MDR, o);
                break;
        }
    }

    public void handleCharInside(Char chr) {
        TemporaryStatManager tsm = chr.getTemporaryStatManager();
        if(tsm.hasAffectedArea(this)) {
            return;
        }
        tsm.addAffectedArea(this);
        int skillID = getSkillID();
        Skill skill = chr.getSkill(getSkillID());
        byte slv = (byte) skill.getCurrentLevel();
        SkillInfo si = SkillData.getSkillInfoById(skillID);
        Option o = new Option();
        Option o1 = new Option();
        Option o2 = new Option();
        Option o3 = new Option();
        switch(skillID) {
            case Zero.TIME_DISTORTION:  // TODO Also adds a benefit to party members in AoE
                break;
            case BlazeWizard.BURNING_CONDUIT:
                o1.nReason = skillID;
                o1.nValue = si.getValue(indieDamR, slv);
                o1.tStart = (int) System.currentTimeMillis();
                tsm.putCharacterStatValue(IndieDamR, o1); //Indie
                o2.nReason = skillID;
                o2.nValue = si.getValue(indieBooster, slv);
                o2.tStart = (int) System.currentTimeMillis();
                tsm.putCharacterStatValue(IndieBooster, o2); //Indie
                break;
            case Kanna.BELLFLOWER_BARRIER:
                //TODO Party Boost
                break;
            case Kanna.BLOSSOM_BARRIER:
                //TODO Party Boost
                break;
        }
        tsm.sendSetStatPacket();
    }
}
