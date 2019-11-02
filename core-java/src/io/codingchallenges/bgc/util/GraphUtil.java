package io.codingchallenges.bgc.util;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *  Utilities for creating Graph
 * @author rajesh
 *
 */
public class GraphUtil {
	
	public static File getFilePath(String fileName) throws FileNotFoundException {
		File file = new File(
				GraphUtil.class.getClassLoader().getResource(fileName).getFile()
			);
		return file;
	}
	
}
