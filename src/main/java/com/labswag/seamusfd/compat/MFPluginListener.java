package com.labswag.seamusfd.compat;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.labswag.seamusfd.libs.ModInfo;
import cpw.mods.fml.common.Loader;
import universalteam.universalcore.api.compat.IPluginListener;
import universalteam.universalcore.api.compat.UCPlugin;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MFPluginListener implements IPluginListener
{
	public List<Method> handleCommon = Lists.newArrayList();
	public List<Method> handleClient = Lists.newArrayList();

	public static MFPluginListener instance = new MFPluginListener();

	@Override
	public String getModID()
	{
		return ModInfo.MODID;
	}

	@Override
	public void handle(Collection<Class<?>> plugins)
	{
		for (Class<?> clazz : plugins)
		{
			UCPlugin plugin = clazz.getAnnotation(UCPlugin.class);

			for (String requiredModID : Splitter.on(';').split(plugin.requires()))
			{
				if (!Loader.isModLoaded(requiredModID))
					break;
			}

			List<Method> methods = Arrays.asList(clazz.getMethods());

			for (Method method : methods)
			{
				boolean commonFound = false;
				boolean clientFound = false;

				if (method.isAnnotationPresent(UCPlugin.Handle.class))
				{
					handleCommon.add(method);
					commonFound = true;
				}

				if (method.isAnnotationPresent(UCPlugin.HandleClient.class))
				{
					handleClient.add(method);
					clientFound = true;
				}

				if (clientFound && commonFound)
					break;
			}
		}
	}

	public static void handleCommon()
	{
		try
		{
			for (Method method : instance.handleCommon)
				method.invoke(instance, null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void handleClient()
	{
		try
		{
			for (Method method : instance.handleClient)
				method.invoke(instance, null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
