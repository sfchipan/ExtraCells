package extracells.localization;

public enum Localization
{
	US("en_US"), GERMAN("de_DE"), CHINESE("zn_CH");

	private final String locale;

	Localization(String locale)
	{
		this.locale = locale;
	}

	public String filename()
	{
		return String.format("/assets/extracells/lang/%s.xml", locale);
	}

	public String locale()
	{
		return locale;
	}
}
