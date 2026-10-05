import java.util.ArrayList;

import net.minecraft.world.entity.Entity;
import net.wurstclient.util.EntityUtils;

public abstract class ChestEspEntityGroup extends ChestEspGroup
{
	private final ArrayList<Entity> entities = new ArrayList<>();
	
	public abstract boolean matches(Entity e);
	
	public final void addIfMatches(Entity e)
	{
		if(!matches(e))
			return;
		
		entities.add(e);
	}
	
	@Override
	public final void clear()
	{
		entities.clear();
		super.clear();
	}
	
	public final void updateBoxes(float partialTicks)
	{
		boxes.clear();
		
		for(Entity e : entities)
			boxes.add(EntityUtils.getLerpedBox(e, partialTicks));
	}
}
