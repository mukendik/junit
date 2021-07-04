package junit5.extensions.conditionaltestexecution;

public @interface Environment {

	String[] enabledFor();

}
