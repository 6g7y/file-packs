import java.util.function.BooleanSupplier;

public final class BadOptimizationsLightmapHook implements BooleanSupplier
{
	private static boolean lightmapNeedsUpdate;
	
	@Override
	public boolean getAsBoolean()
	{
		boolean needsUpdate = lightmapNeedsUpdate;
		lightmapNeedsUpdate = false;
		return needsUpdate;
	}
	
	public static void markForUpdate()
	{
		lightmapNeedsUpdate = true;
	}
}
