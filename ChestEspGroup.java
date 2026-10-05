import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import net.minecraft.world.phys.AABB;
import net.wurstclient.settings.CheckboxSetting;
import net.wurstclient.settings.ColorSetting;
import net.wurstclient.settings.Setting;

public abstract class ChestEspGroup
{
	protected final ArrayList<AABB> boxes = new ArrayList<>();
	private final ColorSetting color;
	private final CheckboxSetting enabled;
	
	public ChestEspGroup()
	{
		enabled = createIncludeSetting();
		color = createColorSetting();
	}
	
	protected abstract CheckboxSetting createIncludeSetting();
	
	protected abstract ColorSetting createColorSetting();
	
	public void clear()
	{
		boxes.clear();
	}
	
	public final boolean isEnabled()
	{
		return enabled == null || enabled.isChecked();
	}
	
	public final Stream<Setting> getSettings()
	{
		return Stream.of(enabled, color).filter(Objects::nonNull);
	}
	
	public final int getColorI(int alpha)
	{
		return color.getColorI(alpha);
	}
	
	public final List<AABB> getBoxes()
	{
		return Collections.unmodifiableList(boxes);
	}
}
