package extracells.model.render;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import extracells.model.ModelSolderingStation;
import extracells.tile.TileEntitySolderingStation;

public class TileEntitySolderingStationRenderer extends TileEntitySpecialRenderer
{

	private ModelSolderingStation model;

	public TileEntitySolderingStationRenderer()
	{
		model = new ModelSolderingStation();
	}

	public void renderAModelAt(TileEntity tile, double d, double d1, double d2, float f)
	{

		FMLClientHandler.instance().getClient().func_110434_K().func_110577_a(new ResourceLocation("extracells","textures/blocks/solderingstation.png")); // texture
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		int orientation = tile.worldObj.getBlockMetadata(tile.xCoord, tile.yCoord, tile.zCoord);
		if (orientation == 4)
		{
			GL11.glRotatef(0, 0, 1, 0);
		} else if (orientation == 2)
		{
			GL11.glRotatef(90, 0, 1, 0);
		} else if (orientation == 5)
		{
			GL11.glRotatef(180, 0, 1, 0);
		} else if (orientation == 3)
		{
			GL11.glRotatef(270, 0, 1, 0);
		}
		model.renderAll(0.0625f);
		GL11.glPopMatrix(); // end
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float tick)
	{
		this.renderAModelAt((TileEntitySolderingStation) tileentity, x, y, z, tick);

	}

}