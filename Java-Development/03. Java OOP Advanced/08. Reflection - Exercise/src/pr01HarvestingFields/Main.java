package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String modifier;

		while (!"harvest".equalsIgnoreCase(modifier = reader.readLine())){
			printFields(modifier);
		}
	}

	private static void printFields(String modifier) {
		Field[] fields = RichSoilLand.class.getDeclaredFields();

		switch (modifier){
			case "private":
				Arrays.stream(fields).filter(field -> Modifier.isPrivate(field.getModifiers()))
						.forEach(field -> System.out.printf("%s %s %s%n",
								Modifier.toString(field.getModifiers()),
										field.getType().getSimpleName(),
										field.getName()));
				break;
			case "protected":
				Arrays.stream(fields).filter(field -> Modifier.isProtected(field.getModifiers()))
						.forEach(field -> System.out.printf("%s %s %s%n",
								Modifier.toString(field.getModifiers()),
								field.getType().getSimpleName(),
								field.getName()));
				break;
			case "public":
				Arrays.stream(fields).filter(field -> Modifier.isPublic(field.getModifiers()))
						.forEach(field -> System.out.printf("%s %s %s%n",
								Modifier.toString(field.getModifiers()),
								field.getType().getSimpleName(),
								field.getName()));
				break;
			case "all":
				Arrays.stream(fields).forEach(field -> System.out.printf("%s %s %s%n",
								Modifier.toString(field.getModifiers()),
								field.getType().getSimpleName(),
								field.getName()));
				break;
		}
	}
}
