package argoelzer.animal.common;

import argoelzer.animal.common.lib.Nomes;
import cpw.mods.fml.common.Mod;
        import cpw.mods.fml.common.SidedProxy;

@Mod(name = Nomes.MOD_NOME, modid =  Nomes.MOD_ID, version = "0.1 teste")
public class AnimalMagic {
    @Mod.Instance(Nomes.MOD_ID)
    public static AnimalMagic instancia;

    @SidedProxy(serverSide = "argoelzer.animal.common.CommonProxy", clientSide = "argoelzer.animal.client.ClientProxy")
    public static CommonProxy proxy;
}
