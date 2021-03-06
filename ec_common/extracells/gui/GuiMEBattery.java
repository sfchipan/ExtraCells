package extracells.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import extracells.network.PacketHandler;
import extracells.tile.TileEntityMEBattery;

public class GuiMEBattery extends GuiScreen
{
	TileEntity tileEntity;
	private final int xSize = 176;
	private final int ySize = 88;
	private double currentEnergy;
	private double maxEnergy;

	public GuiMEBattery(TileEntity tileEntity)
	{
		super();
		this.tileEntity = tileEntity;
	}

	@Override
	public void drawScreen(int x, int y, float f)
	{
		drawDefaultBackground();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		FMLClientHandler.instance().getClient().func_110434_K().func_110577_a(new ResourceLocation("extracells", "textures/gui/solderingstation.png"));
		int posX = (this.width - xSize) / 2;
		int posY = (this.height - ySize) / 2;
		drawTexturedModalRect(posX, posY, 0, 0, xSize, ySize);

		fontRenderer.drawString(StatCollector.translateToLocal("tile.block.mebattery"), posX + 5, posY + 5, 0x000000);
		fontRenderer.drawString("Energy: " + currentEnergy + "/" + maxEnergy, posX + 5, posY + 15, 0x000000);

		super.drawScreen(x, y, f);
	}

	public void keyTyped(char key, int par2)
	{
		if (key == 'e' || key == '')
		{
			this.mc.displayGuiScreen((GuiScreen) null);
			this.mc.setIngameFocus();
		}
	}

	public void updateScreen()
	{
		if (tileEntity instanceof TileEntityMEBattery)
		{
			TileEntityMEBattery battery = (TileEntityMEBattery) tileEntity;
			currentEnergy = battery.getEnergy();
			maxEnergy = battery.getMaxEnergy();
		}
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui()
	{
		int posX = (this.width - xSize) / 2;
		int posY = (this.height - ySize) / 2;

	}
}
