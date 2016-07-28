package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SearchResultsPage extends BasePage {

	@FindBy(id = "advs")
	private WebElement searchForm;

	@FindBy(id = "advs-keywords")
	private WebElement keywordsField;

	@FindBy(name = "submit")
	private WebElement searchButton;

	@FindBy(css = ".div.description")
	private List<WebElement> titleTextList;



	public List<String> getTitlesList(){

		List<String>  titlesTextList = null;
		Iterator<WebElement> i = titleTextList.iterator();
		while (i.hasNext()){
			WebElement titleTextElement = i.next();
			String titleText = titleTextElement.getText();
			titlesTextList.add(titleText);
		}
		return titlesTextList;
	}

	public SearchResultsPage() {
		PageFactory.initElements(driver, this);
		implicitWaitForElement(searchForm);
	}

	public void performSearch (String searchTerm) {
		keywordsField.sendKeys(searchTerm);
		searchButton.click();
	}



}
