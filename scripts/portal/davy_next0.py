# 925100000 - First Map  of the Lord Pirate PQ
def init():
    if sm.getReactorQuantity() > 7 and sm.hasMobsInField():
        sm.chat("The portal is not opened.")
    else:
        sm.warpPartyIn(sm.getFieldID() + 100)
    sm.dispose()