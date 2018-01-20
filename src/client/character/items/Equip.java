package client.character.items;

import connection.OutPacket;
import enums.EquipBaseStat;
import enums.InvType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FileTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 11/23/2017.
 */
@Entity
@Table(name = "equips")
@PrimaryKeyJoinColumn(name = "itemId")
public class Equip extends Item {
    @Column(name = "serialNumber")
    private long serialNumber;
    @Column(name = "title")
    private String title;
    @JoinColumn(name = "equippedDate")
    @OneToOne
    private FileTime equippedDate = new FileTime();
    @Column(name = "prevBonusExpRate")
    private int prevBonusExpRate;
    @Column(name = "ruc")
    private short ruc;
    @Column(name = "cuc")
    private short cuc;
    @Column(name = "iStr")
    private short iStr;
    @Column(name = "iDex")
    private short iDex;
    @Column(name = "iInt")
    private short iInt;
    @Column(name = "iLuk")
    private short iLuk;
    @Column(name = "iMaxHp")
    private short iMaxHp;
    @Column(name = "iMaxMp")
    private short iMaxMp;
    @Column(name = "iPad")
    private short iPad;
    @Column(name = "iMad")
    private short iMad;
    @Column(name = "iPDD")
    private short iPDD;
    @Column(name = "iMDD")
    private short iMDD;
    @Column(name = "iAcc")
    private short iAcc;
    @Column(name = "iEva")
    private short iEva;
    @Column(name = "iCraft")
    private short iCraft;
    @Column(name = "iSpeed")
    private short iSpeed;
    @Column(name = "iJump")
    private short iJump;
    @Column(name = "attribute")
    private short attribute;
    @Column(name = "levelUpType")
    private short levelUpType;
    @Column(name = "level")
    private short level;
    @Column(name = "exp")
    private short exp;
    @Column(name = "durability")
    private short durability;
    @Column(name = "iuc")
    private short iuc;
    @Column(name = "iPvpDamage")
    private short iPvpDamage;
    @Column(name = "iReduceReq")
    private short iReduceReq;
    @Column(name = "specialAttribute")
    private short specialAttribute;
    @Column(name = "durabilityMax")
    private short durabilityMax;
    @Column(name = "iIncReq")
    private short iIncReq;
    @Column(name = "growthEnchant")
    private short growthEnchant;
    @Column(name = "psEnchant")
    private short psEnchant;
    @Column(name = "bdr")
    private short bdr;
    @Column(name = "imdr")
    private short imdr;
    @Column(name = "damR")
    private short damR;
    @Column(name = "statR")
    private short statR;
    @Column(name = "cuttable")
    private short cuttable;
    @Column(name = "exGradeOption")
    private short exGradeOption;
    @Column(name = "itemState")
    private short itemState;
    @Column(name = "grade")
    private short grade;
    @Column(name = "chuc")
    private short chuc;
    @Column(name = "soulOptionId")
    private short soulOptionId;
    @Column(name = "soulSocketId")
    private short soulSocketId;
    @Column(name = "soulOption")
    private short soulOption;
    @Column(name = "rStr")
    private short rStr;
    @Column(name = "rDex")
    private short rDex;
    @Column(name = "rInt")
    private short rInt;
    @Column(name = "rLuk")
    private short rLuk;
    @Column(name = "rLevel")
    private short rLevel;
    @Column(name = "rJob")
    private short rJob;
    @Column(name = "rPop")
    private short rPop;
    @ElementCollection
    @CollectionTable(name = "options", joinColumns = @JoinColumn(name = "equipId"))
    @Column(name = "optionId")
    private List<Integer> options = new ArrayList<>(); // base + add pot
    @Column(name = "specialGrade")
    private int specialGrade;
    @Column(name = "fixedPotential")
    private boolean fixedPotential;
    @Column(name = "tradeBlock")
    private boolean tradeBlock;
    @Column(name = "isOnly")
    private boolean only;
    @Column(name = "notSale")
    private boolean notSale;
    @Column(name = "attackSpeed")
    private int attackSpeed;
    @Column(name = "price")
    private int price;
    @Column(name = "tuc")
    private int tuc;
    @Column(name = "charmEXP")
    private int charmEXP;
    @Column(name = "expireOnLogout")
    private boolean expireOnLogout;
    @Column(name = "setItemID")
    private int setItemID;
    @Column(name = "exItem")
    private boolean exItem;
    @Column(name = "equipTradeBlock")
    private boolean equipTradeBlock;
    @Column(name = "iSlot")
    private String iSlot;
    @Column(name = "vSlot")
    private String vSlot;
    @Column(name = "fixedGrade")
    private int fixedGrade;

    public Equip() {
        super();
    }

    public Equip(int itemId, int bagIndex, long cashItemSerialNumber, FileTime dateExpire, long serialNumber,
                 String title, FileTime equippedDate, int prevBonusExpRate, short ruc, short cuc, short iStr,
                 short iDex, short iInt, short iLuk, short iMaxHp, short iMaxMp, short iPad, short iMad, short iPDD,
                 short iMDD, short iAcc, short iEva, short iCraft, short iSpeed, short iJump, short attribute,
                 short levelUpType, short level, short exp, short durability, short iuc, short iPvpDamage,
                 short iReduceReq, short specialAttribute, short durabilityMax, short iIncReq, short growthEnchant,
                 short psEnchant, short bdr, short imdr, short damR, short statR, short cuttable, short exGradeOption,
                 short itemState, short grade, short chuc, short soulOptionId, short soulSocketId, short soulOption,
                 short rStr, short rDex, short rInt, short rLuk, short rLevel, short rJob, short rPop, boolean isCash,
                 String iSlot, String vSlot, int fixedGrade, List<Integer> options, int specialGrade, boolean fixedPotential,
                 boolean tradeBlock, boolean only, boolean notSale, int attackSpeed, int price, int tuc, int charmEXP,
                 boolean expireOnLogout, int setItemID, boolean exItem, boolean hasEquipTradeBlock, String owner) {
        super(itemId, bagIndex, cashItemSerialNumber, dateExpire, InvType.EQUIP, isCash, Type.EQUIP);
        this.serialNumber = serialNumber;
        this.title = title;
        this.equippedDate = equippedDate;
        this.prevBonusExpRate = prevBonusExpRate;
        this.ruc = ruc;
        this.cuc = cuc;
        this.iStr = iStr;
        this.iDex = iDex;
        this.iInt = iInt;
        this.iLuk = iLuk;
        this.iMaxHp = iMaxHp;
        this.iMaxMp = iMaxMp;
        this.iPad = iPad;
        this.iMad = iMad;
        this.iPDD = iPDD;
        this.iMDD = iMDD;
        this.iAcc = iAcc;
        this.iEva = iEva;
        this.iCraft = iCraft;
        this.iSpeed = iSpeed;
        this.iJump = iJump;
        this.attribute = attribute;
        this.levelUpType = levelUpType;
        this.level = level;
        this.exp = exp;
        this.durability = durability;
        this.iuc = iuc;
        this.iPvpDamage = iPvpDamage;
        this.iReduceReq = iReduceReq;
        this.specialAttribute = specialAttribute;
        this.durabilityMax = durabilityMax;
        this.iIncReq = iIncReq;
        this.growthEnchant = growthEnchant;
        this.psEnchant = psEnchant;
        this.bdr = bdr;
        this.imdr = imdr;
        this.damR = damR;
        this.statR = statR;
        this.cuttable = cuttable;
        this.exGradeOption = exGradeOption;
        this.itemState = itemState;
        this.grade = grade;
        this.chuc = chuc;
        this.soulOptionId = soulOptionId;
        this.soulSocketId = soulSocketId;
        this.soulOption = soulOption;
        this.rStr = rStr;
        this.rDex = rDex;
        this.rInt = rInt;
        this.rLuk = rLuk;
        this.rLevel = rLevel;
        this.rJob = rJob;
        this.rPop = rPop;
        this.iSlot = iSlot;
        this.vSlot = vSlot;
        this.fixedGrade = fixedGrade;
        this.options = options;
        this.specialGrade = specialGrade;
        this.fixedPotential = fixedPotential;
        this.tradeBlock = tradeBlock;
        this.only = only;
        this.notSale = notSale;
        this.attackSpeed = attackSpeed;
        this.price = price;
        this.tuc = tuc;
        this.charmEXP = charmEXP;
        this.expireOnLogout = expireOnLogout;
        this.setItemID = setItemID;
        this.exItem = exItem;
        equipTradeBlock = hasEquipTradeBlock;
        this.setOwner(owner);
    }

    public Equip deepCopy() {
        Equip ret = new Equip();
        ret.serialNumber = serialNumber;
        ret.title = title;
        ret.equippedDate = equippedDate;
        ret.prevBonusExpRate = prevBonusExpRate;
        ret.ruc = ruc;
        ret.cuc = cuc;
        ret.iStr = iStr;
        ret.iDex = iDex;
        ret.iInt = iInt;
        ret.iLuk = iLuk;
        ret.iMaxHp = iMaxHp;
        ret.iMaxMp = iMaxMp;
        ret.iPad = iPad;
        ret.iMad = iMad;
        ret.iPDD = iPDD;
        ret.iMDD = iMDD;
        ret.iAcc = iAcc;
        ret.iEva = iEva;
        ret.iCraft = iCraft;
        ret.iSpeed = iSpeed;
        ret.iJump = iJump;
        ret.attribute = attribute;
        ret.levelUpType = levelUpType;
        ret.level = level;
        ret.exp = exp;
        ret.durability = durability;
        ret.iuc = iuc;
        ret.iPvpDamage = iPvpDamage;
        ret.iReduceReq = iReduceReq;
        ret.specialAttribute = specialAttribute;
        ret.durabilityMax = durabilityMax;
        ret.iIncReq = iIncReq;
        ret.growthEnchant = growthEnchant;
        ret.psEnchant = psEnchant;
        ret.bdr = bdr;
        ret.imdr = imdr;
        ret.damR = damR;
        ret.statR = statR;
        ret.cuttable = cuttable;
        ret.exGradeOption = exGradeOption;
        ret.itemState = itemState;
        ret.grade = grade;
        ret.chuc = chuc;
        ret.soulOptionId = soulOptionId;
        ret.soulSocketId = soulSocketId;
        ret.soulOption = soulOption;
        ret.rStr = rStr;
        ret.rDex = rDex;
        ret.rInt = rInt;
        ret.rLuk = rLuk;
        ret.rLevel = rLevel;
        ret.rJob = rJob;
        ret.rPop = rPop;
        ret.iSlot = iSlot;
        ret.vSlot = vSlot;
        ret.fixedGrade = fixedGrade;
        ret.options = options;
        ret.specialGrade = specialGrade;
        ret.fixedPotential = fixedPotential;
        ret.tradeBlock = tradeBlock;
        ret.only = only;
        ret.notSale = notSale;
        ret.attackSpeed = attackSpeed;
        ret.price = price;
        ret.tuc = tuc;
        ret.charmEXP = charmEXP;
        ret.expireOnLogout = expireOnLogout;
        ret.setItemID = setItemID;
        ret.exItem = exItem;
        ret.equipTradeBlock = equipTradeBlock;
        ret.setOwner(getOwner());
        ret.itemId = itemId;
        ret.cashItemSerialNumber = cashItemSerialNumber;
        ret.dateExpire = dateExpire.deepCopy();
        ret.invType = invType;
        ret.type = type;
        ret.isCash = isCash;
        return ret;
    }

    public long getSerialNumber() {
        return getId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FileTime getEquippedDate() {
        return equippedDate;
    }

    public int getPrevBonusExpRate() {
        return prevBonusExpRate;
    }

    public short getRuc() {
        return ruc;
    }

    public short getCuc() {
        return cuc;
    }

    public void setCuc(short cuc) {
        this.cuc = cuc;
    }

    public short getiStr() {
        return iStr;
    }

    public void setiStr(short iStr) {
        this.iStr = iStr;
    }

    public short getiDex() {
        return iDex;
    }

    public void setiDex(short iDex) {
        this.iDex = iDex;
    }

    public short getiInt() {
        return iInt;
    }

    public void setiInt(short iInt) {
        this.iInt = iInt;
    }

    public short getiLuk() {
        return iLuk;
    }

    public void setiLuk(short iLuk) {
        this.iLuk = iLuk;
    }

    public short getiMaxHp() {
        return iMaxHp;
    }

    public void setiMaxHp(short iMaxHp) {
        this.iMaxHp = iMaxHp;
    }

    public short getiMaxMp() {
        return iMaxMp;
    }

    public void setiMaxMp(short iMaxMp) {
        this.iMaxMp = iMaxMp;
    }

    public short getiPad() {
        return iPad;
    }

    public void setiPad(short iPad) {
        this.iPad = iPad;
    }

    public short getiMad() {
        return iMad;
    }

    public void setiMad(short iMad) {
        this.iMad = iMad;
    }

    public short getiPDD() {
        return iPDD;
    }

    public void setiPDD(short iPDD) {
        this.iPDD = iPDD;
    }

    public short getiMDD() {
        return iMDD;
    }

    public void setiMDD(short iMDD) {
        this.iMDD = iMDD;
    }

    public short getiAcc() {
        return iAcc;
    }

    public void setiAcc(short iAcc) {
        this.iAcc = iAcc;
    }

    public short getiEva() {
        return iEva;
    }

    public void setiEva(short iEva) {
        this.iEva = iEva;
    }

    public short getiCraft() {
        return iCraft;
    }

    public void setiCraft(short iCraft) {
        this.iCraft = iCraft;
    }

    public short getiSpeed() {
        return iSpeed;
    }

    public void setiSpeed(short iSpeed) {
        this.iSpeed = iSpeed;
    }

    public short getiJump() {
        return iJump;
    }

    public void setiJump(short iJump) {
        this.iJump = iJump;
    }

    public short getAttribute() {
        return attribute;
    }

    public void setAttribute(short attribute) {
        this.attribute = attribute;
    }

    public short getLevelUpType() {
        return levelUpType;
    }

    public void setLevelUpType(short levelUpType) {
        this.levelUpType = levelUpType;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public short getExp() {
        return exp;
    }

    public void setExp(short exp) {
        this.exp = exp;
    }

    public short getDurability() {
        return durability;
    }

    public void setDurability(short durability) {
        this.durability = durability;
    }

    public short getIuc() {
        return iuc;
    }

    public void setIuc(short iuc) {
        this.iuc = iuc;
    }

    public short getiPvpDamage() {
        return iPvpDamage;
    }

    public void setiPvpDamage(short iPvpDamage) {
        this.iPvpDamage = iPvpDamage;
    }

    public short getiReduceReq() {
        return iReduceReq;
    }

    public void setiReduceReq(short iReduceReq) {
        this.iReduceReq = iReduceReq;
    }

    public short getSpecialAttribute() {
        return specialAttribute;
    }

    public void setSpecialAttribute(short specialAttribute) {
        this.specialAttribute = specialAttribute;
    }

    public short getExGradeOption() {
        return exGradeOption;
    }

    public void setExGradeOption(short exGradeOption) {
        this.exGradeOption = exGradeOption;
    }

    public short getCuttable() {
        return cuttable;
    }

    public void setCuttable(short cuttable) {
        this.cuttable = cuttable;
    }

    public short getStatR() {
        return statR;
    }

    public void setStatR(short statR) {
        this.statR = statR;
    }

    public short getDamR() {
        return damR;
    }

    public void setDamR(short damR) {
        this.damR = damR;
    }

    public short getImdr() {
        return imdr;
    }

    public void setImdr(short imdr) {
        this.imdr = imdr;
    }

    public short getBdr() {
        return bdr;
    }

    public void setBdr(short bdr) {
        this.bdr = bdr;
    }

    public short getPsEnchant() {
        return psEnchant;
    }

    public void setPsEnchant(short psEnchant) {
        this.psEnchant = psEnchant;
    }

    public short getGrowthEnchant() {
        return growthEnchant;
    }

    public void setGrowthEnchant(short growthEnchant) {
        this.growthEnchant = growthEnchant;
    }

    public short getiIncReq() {
        return iIncReq;
    }

    public void setiIncReq(short iIncReq) {
        this.iIncReq = iIncReq;
    }

    public short getDurabilityMax() {
        return durabilityMax;
    }

    public void setDurabilityMax(short durabilityMax) {
        this.durabilityMax = durabilityMax;
    }

    public short getItemState() {
        return itemState;
    }

    public void setItemState(short itemState) {
        this.itemState = itemState;
    }

    public short getGrade() {
        return grade;
    }

    public void setGrade(short grade) {
        this.grade = grade;
    }

    public short getChuc() {
        return chuc;
    }

    public void setChuc(short chuc) {
        this.chuc = chuc;
    }

    public short getSoulOptionId() {
        return soulOptionId;
    }

    public void setSoulOptionId(short soulOptionId) {
        this.soulOptionId = soulOptionId;
    }

    public short getSoulSocketId() {
        return soulSocketId;
    }

    public void setSoulSocketId(short soulSocketId) {
        this.soulSocketId = soulSocketId;
    }

    public short getSoulOption() {
        return soulOption;
    }

    public void setSoulOption(short soulOption) {
        this.soulOption = soulOption;
    }

    public short getrPop() {
        return rPop;
    }

    public void setrPop(short rPop) {
        this.rPop = rPop;
    }

    public short getrJob() {
        return rJob;
    }

    public void setrJob(short rJob) {
        this.rJob = rJob;
    }

    public short getrLevel() {
        return rLevel;
    }

    public void setrLevel(short rLevel) {
        this.rLevel = rLevel;
    }

    public short getrLuk() {
        return rLuk;
    }

    public void setrLuk(short rLuk) {
        this.rLuk = rLuk;
    }

    public short getrInt() {
        return rInt;
    }

    public void setrInt(short rInt) {
        this.rInt = rInt;
    }

    public short getrDex() {
        return rDex;
    }

    public void setrDex(short rDex) {
        this.rDex = rDex;
    }

    public short getrStr() {
        return rStr;
    }

    public void setrStr(short rStr) {
        this.rStr = rStr;
    }

    public List<Integer> getOptions() {
        return options;
    }

    public void setOptions(List<Integer> options) {
        this.options = options;
    }

    public String getiSlot() {
        return iSlot;
    }

    public void setiSlot(String iSlot) {
        this.iSlot = iSlot;
    }

    public String getvSlot() {
        return vSlot;
    }

    public void setvSlot(String vSlot) {
        this.vSlot = vSlot;
    }

    public int getSpecialGrade() {
        return specialGrade;
    }

    public boolean isFixedPotential() {
        return fixedPotential;
    }

    public boolean isTradeBlock() {
        return tradeBlock;
    }

    public boolean isOnly() {
        return only;
    }

    public boolean isNotSale() {
        return notSale;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public int getPrice() {
        return price;
    }

    public int getTuc() {
        return tuc;
    }

    public int getCharmEXP() {
        return charmEXP;
    }

    public boolean isExpireOnLogout() {
        return expireOnLogout;
    }

    public int getSetItemID() {
        return setItemID;
    }

    public int getFixedGrade() {
        return fixedGrade;
    }

    public boolean isExItem() {
        return exItem;
    }

    public boolean isEquipTradeBlock() {
        return equipTradeBlock;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setEquippedDate(FileTime equippedDate) {
        this.equippedDate = equippedDate;
    }

    public void setPrevBonusExpRate(int prevBonusExpRate) {
        this.prevBonusExpRate = prevBonusExpRate;
    }

    public void setRuc(short ruc) {
        this.ruc = ruc;
    }

    public void setSpecialGrade(int specialGrade) {
        this.specialGrade = specialGrade;
    }

    public void setFixedPotential(boolean fixedPotential) {
        this.fixedPotential = fixedPotential;
    }

    public void setTradeBlock(boolean tradeBlock) {
        this.tradeBlock = tradeBlock;
    }

    public void setOnly(boolean only) {
        this.only = only;
    }

    public void setNotSale(boolean notSale) {
        this.notSale = notSale;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTuc(int tuc) {
        this.tuc = tuc;
    }

    public void setCharmEXP(int charmEXP) {
        this.charmEXP = charmEXP;
    }

    public void setExpireOnLogout(boolean expireOnLogout) {
        this.expireOnLogout = expireOnLogout;
    }

    public void setSetItemID(int setItemID) {
        this.setItemID = setItemID;
    }

    public void setExItem(boolean exItem) {
        this.exItem = exItem;
    }

    public void setEquipTradeBlock(boolean equipTradeBlock) {
        this.equipTradeBlock = equipTradeBlock;
    }

    public void setFixedGrade(int fixedGrade) {
        this.fixedGrade = fixedGrade;
    }

    public void encode(OutPacket outPacket) {
        // GW_ItemSlotBase
        super.encode(outPacket);
        // GW_ItemSlotEquip
//        outPacket.encodeLong(getSerialNumber());
//        outPacket.encodeString(getTitle(), 13);
//        getEquippedDate().encode(outPacket);
//        outPacket.encodeInt(getPrevBonusExpRate());
        // GW_ItemSlotEquipBase
        int mask0 = getStatMask(0);
        outPacket.encodeInt(mask0);
        if(hasStat(EquipBaseStat.ruc)) {
            outPacket.encodeShort(getTuc());
        }
        if(hasStat(EquipBaseStat.cuc)) {
            outPacket.encodeShort(getCuc());
        }
        if(hasStat(EquipBaseStat.iStr)) {
            outPacket.encodeShort(getiStr());
        }
        if(hasStat(EquipBaseStat.iDex)) {
            outPacket.encodeShort(getiDex());
        }
        if(hasStat(EquipBaseStat.iInt)) {
            outPacket.encodeShort(getiInt());
        }
        if(hasStat(EquipBaseStat.iLuk)) {
            outPacket.encodeShort(getiLuk());
        }
        if(hasStat(EquipBaseStat.iMaxHP)) {
            outPacket.encodeShort(getiMaxHp());
        }
        if(hasStat(EquipBaseStat.iMaxMP)) {
            outPacket.encodeShort(getiMaxMp());
        }
        if(hasStat(EquipBaseStat.iPAD)) {
            outPacket.encodeShort(getiPad());
        }
        if(hasStat(EquipBaseStat.iMAD)) {
            outPacket.encodeShort(getiMad());
        }
        if(hasStat(EquipBaseStat.iPDD)) {
            outPacket.encodeShort(getiPDD());
        }
        if(hasStat(EquipBaseStat.iMDD)) {
            outPacket.encodeShort(getiMDD());
        }
        if(hasStat(EquipBaseStat.iACC)) {
            outPacket.encodeShort(getiAcc());
        }
        if(hasStat(EquipBaseStat.iEVA)) {
            outPacket.encodeShort(getiEva());
        }
        if(hasStat(EquipBaseStat.iCraft)) {
            outPacket.encodeShort(getiCraft());
        }
        if(hasStat(EquipBaseStat.iSpeed)) {
            outPacket.encodeShort(getiSpeed());
        }
        if(hasStat(EquipBaseStat.iJump)) {
            outPacket.encodeShort(getiJump());
        }
        if(hasStat(EquipBaseStat.attribute)) {
            outPacket.encodeShort(getAttribute());
        }
        if(hasStat(EquipBaseStat.levelUpType)) {
            outPacket.encodeByte(getLevelUpType());
        }
        if(hasStat(EquipBaseStat.level)) {
            outPacket.encodeByte(getLevel());
        }
        if(hasStat(EquipBaseStat.exp)) {
            outPacket.encodeLong(getExp());
        }
        if(hasStat(EquipBaseStat.durability)) {
            outPacket.encodeInt(getDurability());
        }
        if(hasStat(EquipBaseStat.iuc)) {
            outPacket.encodeInt(getIuc()); // hammer
        }
        if(hasStat(EquipBaseStat.iPvpDamage)) {
            outPacket.encodeShort(getiPvpDamage());
        }
        if(hasStat(EquipBaseStat.specialAttribute)) {
            outPacket.encodeShort(getSpecialAttribute());
        }
        if(hasStat(EquipBaseStat.durabilityMax)) {
            outPacket.encodeInt(getDurabilityMax());
        }
        if(hasStat(EquipBaseStat.iIncReq)) {
            outPacket.encodeByte(getrLevel());
        }
        if(hasStat(EquipBaseStat.growthEnchant)) {
            outPacket.encodeByte(getGrowthEnchant()); // ygg
        }
        if(hasStat(EquipBaseStat.psEnchant)) {
            outPacket.encodeByte(getPsEnchant()); // final strike
        }
        if(hasStat(EquipBaseStat.bdr)) {
            outPacket.encodeByte(getBdr()); // bd
        }
        if(hasStat(EquipBaseStat.imdr)) {
            outPacket.encodeByte(getImdr()); // ied
        }
        outPacket.encodeInt(getStatMask(1)); // mask 2
        if(hasStat(EquipBaseStat.damR)) {
            outPacket.encodeByte(getDamR()); // td
        }
        if(hasStat(EquipBaseStat.statR)) {
            outPacket.encodeByte(getStatR()); // as
        }
        if(hasStat(EquipBaseStat.cuttable)) {
            outPacket.encodeByte(getCuttable()); // soc
        }
        if(hasStat(EquipBaseStat.exGradeOption)) {
            outPacket.encodeLong(getExGradeOption());
        }
        if(hasStat(EquipBaseStat.itemState)) {
            outPacket.encodeInt(getItemState());
        }
        // GW_ItemSlotEquipOpt
        outPacket.encodeString(getOwner());
        outPacket.encodeByte(getGrade());
        outPacket.encodeByte(getChuc());
        for (int i = 0; i < 7; i++) {
            outPacket.encodeShort(getOptions().get(i)); // 7x, last is fusion anvil
        }
        outPacket.encodeShort(-1); // socket state
        for(int i = 0; i < 3; i++) {
            outPacket.encodeShort(-1); // sockets 0 through 2 (-1 = none, 0 = empty, >0 = filled
        }
        outPacket.encodeLong(getId()); // ?
        outPacket.encodeInt(-1); // ?
        // GW_CashItemOption
        outPacket.encodeLong(getCashItemSerialNumber());
        getDateExpire().encode(outPacket);
        outPacket.encodeFT(FileTime.getFileTimeFromType(FileTime.Type.ZERO_TIME));
        for (int i = 0; i < 2; i++) {
            outPacket.encodeLong(0);
        }
        outPacket.encodeShort(getSoulOptionId());
        outPacket.encodeShort(getSoulSocketId());
        outPacket.encodeShort(getSoulOption());
    }

    private boolean hasStat(EquipBaseStat ebs) {
        return getBaseStat(ebs) != 0;
    }

    private int getStatMask(int pos) {
        int mask = 0;
        for (EquipBaseStat ebs : EquipBaseStat.values()) {
            if (getBaseStat(ebs) != 0 && ebs.getPos() == pos) {
                mask |= ebs.getVal();
//                System.out.println(ebs);
            }
        }
//        System.out.println("Mask for item " + itemId + " at pos " + pos + ": " + mask);
        return mask;
    }

    public void setBaseStat(EquipBaseStat equipBaseStat, long amount) {
        switch(equipBaseStat){
            case ruc:
                setRuc((short) amount);
            case cuc:
                setCuc((short) amount);
            case iStr:
                setiStr((short) amount);
            case iDex:
                setiDex((short) amount);
            case iInt:
                setiInt((short) amount);
            case iLuk:
                setiLuk((short) amount);
            case iMaxHP:
                setiMaxHp((short) amount);
            case iMaxMP:
                setiMaxMp((short) amount);
            case iPAD:
                setiPad((short) amount);
            case iMAD:
                setiMad((short) amount);
            case iPDD:
                setiPDD((short) amount);
            case iMDD:
                setiMDD((short) amount);
            case iACC:
                setiAcc((short) amount);
            case iEVA:
                setiEva((short) amount);
            case iCraft:
                setiCraft((short) amount);
            case iSpeed:
                setiSpeed((short) amount);
            case iJump:
                setiJump((short) amount);
            case attribute:
                setAttribute((short) amount);
            case levelUpType:
                setLevelUpType((short) amount);
            case level:
                setLevel((short) amount);
            case exp:
                setExp((short) amount);
            case durability:
                setDurability((short) amount);
            case iuc:
                setIuc((short) amount);
            case iPvpDamage:
                setiPvpDamage((short) amount);
            case iReduceReq:
                setiReduceReq((short) amount);
            case specialAttribute:
                setSpecialAttribute((short) amount);
            case durabilityMax:
                setDurabilityMax((short) amount);
            case iIncReq:
                setiIncReq((short) amount);
            case growthEnchant:
                setGrowthEnchant((short) amount);
            case psEnchant:
                setPsEnchant((short) amount);
            case bdr:
                setBdr((short) amount);
            case imdr:
                setImdr((short) amount);
            case damR:
                setDamR((short) amount);
            case statR:
                setStatR((short) amount);
            case cuttable:
                setCuttable((short) amount);
            case exGradeOption:
                setExGradeOption((short) amount);
            case itemState:
                setItemState((short) amount);
        }
    }

    public long getBaseStat(EquipBaseStat equipBaseStat) {
        switch(equipBaseStat){
            case ruc:
                return getRuc();
            case cuc:
                return getCuc();
            case iStr:
                return getiStr();
            case iDex:
                return getiDex();
            case iInt:
                return getiInt();
            case iLuk:
                return getiLuk();
            case iMaxHP:
                return getiMaxHp();
            case iMaxMP:
                return getiMaxMp();
            case iPAD:
                return getiPad();
            case iMAD:
                return getiMad();
            case iPDD:
                return getiPDD();
            case iMDD:
                return getiMDD();
            case iACC:
                return getiAcc();
            case iEVA:
                return getiEva();
            case iCraft:
                return getiCraft();
            case iSpeed:
                return getiSpeed();
            case iJump:
                return getiJump();
            case attribute:
                return getAttribute();
            case levelUpType:
                return getLevelUpType();
            case level:
                return getLevel();
            case exp:
                return getExp();
            case durability:
                return getDurability();
            case iuc:
                return getIuc();
            case iPvpDamage:
                return getiPvpDamage();
            case iReduceReq:
                return getiReduceReq();
            case specialAttribute:
                return getSpecialAttribute();
            case durabilityMax:
                return getDurabilityMax();
            case iIncReq:
                return getiIncReq();
            case growthEnchant:
                return getGrowthEnchant();
            case psEnchant:
                return getPsEnchant();
            case bdr:
                return getBdr();
            case imdr:
                return getImdr();
            case damR:
                return getDamR();
            case statR:
                return getStatR();
            case cuttable:
                return getCuttable();
            case exGradeOption:
                return getExGradeOption();
            case itemState:
                return getItemState();
            default: return 0;
        }
    }

    @Override
    public void updateDB(Session session, Transaction tx) {
        super.updateDB(session, tx);
        getEquippedDate().updateDB(session, tx);
    }

    public void addStat(EquipBaseStat stat, int amount) {
        int cur = (int) getBaseStat(stat);
        int newStat = cur + amount >= 0 ? cur + amount : 0; // stat cannot be negative
        setBaseStat(stat, newStat);
    }
    
}
