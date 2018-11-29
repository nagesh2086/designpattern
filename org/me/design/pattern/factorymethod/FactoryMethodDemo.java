package org.me.design.pattern.factorymethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Define an interface for creating an object, but let subclasses decide which
 * class to instantiate. Factory Method lets a class defer instantiation to
 * subclasses.
 * 
 * @author kekannag
 *
 */
public class FactoryMethodDemo {

	public static void main(String[] args) {
		System.out.println(
				"* Define an interface for creating an object, but let subclasses decide which class to instantiate. \r\n"
						+ " * Factory Method lets a class defer instantiation to subclasses.");
		System.out.println("--------------------------------------------------------------------------\n");
		Document reportDocument = new ReportDocument();
		reportDocument.createPages();

		Document resumeDocument = new ResumeDocument();
		resumeDocument.createPages();

		System.out.println(reportDocument.getClass().getName());
		System.out.println(reportDocument.getPages());

		System.out.println("--------------------------------------------------------------------------\n");

		System.out.println(resumeDocument.getClass().getName());
		System.out.println(resumeDocument.getPages());
	}

}

abstract class Page {

}

class SkillPage extends Page {

	@Override
	public String toString() {
		return "SkillPage []";
	}

}

class EducationPage extends Page {

	@Override
	public String toString() {
		return "EducationPage []";
	}
}

class ExperiencePage extends Page {

	@Override
	public String toString() {
		return "ExperiencePage []";
	}
}

class IntroductionPage extends Page {

	@Override
	public String toString() {
		return "IntroductionPage []";
	}
}

class ConclusionPage extends Page {

	@Override
	public String toString() {
		return "ConclusionPage []";
	}
}

class ResultPage extends Page {
	@Override
	public String toString() {
		return "ResultPage []";
	}

}

class SummaryPage extends Page {

	@Override
	public String toString() {
		return "SummaryPage []";
	}
}

class BibliographyPage extends Page {

	@Override
	public String toString() {
		return "BibliographyPage []";
	}
}

abstract class Document {
	private List<Page> pages = new ArrayList<>();

	public Document() {
		this.createPages();
	}

	public List<Page> getPages() {
		return pages;
	}

	protected abstract void createPages();
}

class ReportDocument extends Document {

	@Override
	protected void createPages() {
		getPages().add(new SkillPage());
		getPages().add(new EducationPage());
		getPages().add(new ExperiencePage());
	}

}

class ResumeDocument extends Document {

	@Override
	protected void createPages() {
		getPages().add(new BibliographyPage());
		getPages().add(new SummaryPage());
		getPages().add(new ResultPage());
		getPages().add(new ConclusionPage());
		getPages().add(new IntroductionPage());
	}

}
