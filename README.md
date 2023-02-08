# CPTM
A minecraft mod that changes the appearance of certain mobs
一个我的世界娘化mod

# Info
这个mod是教程 https://www.bilibili.com/read/cv17556579 的示例mod

mod中所有的皮肤**不是**我画的，它们修改自以下来源，我进行的修改可以在/resources/assets/testmod/textures/extensions处查看。
这些皮肤仅作mod效果的展示作用，我没有将其替换为空皮肤只是因为我懒
**我不确定对这些皮肤使用或者修改的协议如何，因此如果您是皮肤的作者，您不希望您的皮肤出现在这里，请在b站上联系我（我看私信不是特别勤），或者在github直接举报侵权，我会尽快将其删除，对您造成的不便我表示抱歉。**

{
  "info": [
    "extands 原始皮肤来源",
    "头部皮肤原始来源 extends 躯体皮肤原始来源",
    "皮肤原始来源",
    "net.内置命名域.内置皮肤名称",
    "* implement 应用方法参考"
  ],
  "cptmzombie" : "extends https://www.mcbbs.net/thread-1075669-1-1.html",
  "cptmblaze" : "https://www.mcbbs.net/thread-1179995-1-1.html extends https://www.planetminecraft.com/skin/frp-tea-scholar implement net.minecraft.assets.textures.entity.blaze",
  "cptmskeleton" : "https://www.mcbbs.net/thread-1179995-1-1.html",
  "cptmwitherskeleton" : "extends https://www.mcbbs.net/thread-1179995-1-1.html",
  "cptmstray" : "extends https://www.mcbbs.net/thread-1179995-1-1.html",
  "cptmhusk" : "https://www.mcbbs.net/thread-1179995-1-1.html extends https://www.mcbbs.net/thread-1284702-1-1.html",
  "cptmdrowned" : "https://www.mcbbs.net/thread-1306223-1-1.html extends https://www.mcbbs.net/thread-1215413-1-1.html",
  "cptmpiglin" : "https://www.mcbbs.net/thread-1306223-1-1.html extends hhttps://www.mcbbs.net/thread-1179995-1-1.html",
  "cptmzombiefiedpiglin" : "https://www.mcbbs.net/thread-1306223-1-1.html extends https://www.mcbbs.net/thread-1179995-1-1.html implement https://www.mcbbs.net/thread-1302552-1-1.html",
  "cptmpiglinbrute" : "https://www.mcbbs.net/thread-1306223-1-1.html extends https://www.mcbbs.net/thread-1306223-1-1.html",
  "cptmenderman" : "https://www.mcbbs.net/thread-1179995-1-1.html extends https://www.mcbbs.net/thread-918718-1-1.html",
  "cptmcreeper" : "https://www.mcbbs.net/thread-1306223-1-1.html extends https://www.mcbbs.net/thread-1179995-1-1.html",
  "cptmcreeperarmor" : "net.minecraft.assets.textures.entity.creeper.creeper_armor",
  "cptmsnowgolem" : "extends https://www.planetminecraft.com/skin/yeti-blues",
  "cptmghast" : "extends https://www.planetminecraft.com/skin/-4493356",
  "cptmghastshooting" : "extends https://www.planetminecraft.com/skin/-4493356 implement https://www.planetminecraft.com/skin/shoto-todoroki-boku-no-hero-academia",
  "cptmwither" : "https://www.mcbbs.net/thread-1179995-1-1.html",
  "cptmslime" : "extends https://www.mcbbs.net/thread-1306223-1-1.html",
  "cptmmagmacube" : "https://www.mcbbs.net/thread-1306223-1-1.html extends https://www.planetminecraft.com/skin/golem-of-thy-blackstone-that-was-also-a-skin-of-thy-commission",
  "cptmspider & cptmcavespider" : "https://www.mcbbs.net/thread-1075669-1-1.html extends https://www.minecraftskins.net/ghostrobes",
  "cptmguardian & cptmelderguardian" : "https://www.mcbbs.net/thread-1075669-1-1.html extends https://www.planetminecraft.com/skin/atlantis-3935888",
  "cptmphantom" : "extends https://www.mcbbs.net/thread-1215413-1-1.html",
  "cptmevoker & cptmillusioner & cptmwitch" : "https://www.mcbbs.net/thread-1075669-1-1.html extends https://www.mcbbs.net/thread-1242641-1-1.html",
  "cptmpillager & cptmvindicator" : "https://www.mcbbs.net/thread-1075669-1-1.html extends https://www.mcbbs.net/thread-1306223-1-1.html",
  "cptmvex" : "extends https://www.mcbbs.net/thread-1075669-1-1.html",
  "cptmwanderingtrader" : "https://www.mcbbs.net/thread-1075669-1-1.html extends https://www.mcbbs.net/thread-1306223-1-1.html",
  "cptmirongolem" : "https://www.mcbbs.net/thread-1075669-1-1.html extends https://www.planetminecraft.com/skin/-pulsefire-ezreal-lv16-",
  "cptmvillager & cptmzombievillager" : "extends https://www.mcbbs.net/thread-1215413-1-1.html & https://www.mcbbs.net/thread-1306223-1-1.html &https://www.mcbbs.net/thread-1242641-1-1.html & https://www.mcbbs.net/thread-1075669-1-1.html implement https://www.planetminecraft.com/skin/the-farmer-2357601/ & https://www.planetminecraft.com/skin/new-minecraft-1-14-fletcher-villager/ & https://www.planetminecraft.com/skin/vaelyan-knight-no-helmet/",
  "cptmcat" : "mix https://www.planetminecraft.com/skin/cat-maid-base & https://www.mcbbs.net/thread-1306223-1-1.html & https://www.mcbbs.net/thread-1075669-1-1.html &https://www.mcbbs.net/thread-1291053-1-1.html"
}

其余部分元素来自minecraft1.19原版的assets
这个mod修改自fabric的模板，其使用cc0协议，在此对其表示感谢

# 修改的生物

CatEntity
EndermanEntity
CreeperEntity
DrownedEntity
HuskEntity
EndermiteEntity
PiglinEntity
PiglinBruteEntity
SilverfishEntity
SkeletonEntity
StrayEntity
WitherSkeletonEntity
ZombieEntity
ZombifiedPiglinEntity
SnowGolemEntity
GhastEntity
BlazeEntity
WitherEntity
MagemaCubeEntity
SlimeEntity
CaveSpiderEntity
SpiderEntity
ElderGuardianEntity
GuardianEntity
PhantomEntity
EvokerEntity
IllusionerEntity
PillagerEntity
VindicatorEntity
VexEntity
WanderingTraderEntity
WitchEntity
IronGolemEntity
VillagerEntity
ZombieVillagerEntity
