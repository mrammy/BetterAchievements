package thevault.asm.obfuscation;

import net.minecraftforge.classloading.FMLForgePlugin;

public class ASMString
{
    public static boolean OBFUSCATED = FMLForgePlugin.RUNTIME_DEOBF;
    private String text;
    private String obfText;

    public ASMString(String text)
    {
        this(text, text);
    }

    public ASMString(Class clazz)
    {
        this(clazz.getCanonicalName());
    }

    public ASMString(String text, String obfText)
    {
        this.text = text;
        this.obfText = obfText;
    }

    public String getText()
    {
        return OBFUSCATED ? obfText : text;
    }

    public String getReadableText()
    {
        return text;
    }

    public String getASMClassName()
    {
        return OBFUSCATED ? obfText : text.replaceAll("\\.","/");
    }

    public String getASMTypeName()
    {
        return "L" + getASMClassName() +";";
    }
}
