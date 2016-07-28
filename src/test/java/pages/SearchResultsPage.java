package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.Kernel32;
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

	@FindBy(css = ".submit-advs")
	private WebElement searchButton;

	@FindBy(css = ".div.description")
	private List<WebElement> titleTextList;


	@FindBy(css = ".suggested-search.bd>a")
	private List<WebElement> showAllResults;







	private List<WebElement> titleTextWebElementList;

	private List<String> getTitlesList(){


		List<String>  titlesTextList = null;
		Iterator<WebElement> i = titleTextWebElementList.iterator();
		while (i.hasNext()){
			WebElement titleTextWebElementList = i.next();
			String titleText = titleTextWebElementList.getText();
			titlesTextList.add(titleText);
		}
		return titlesTextList;
	}

	public void printEachTitleText(){
		List<String> titleTextList = getTitlesList();

			System.out.println(titleTextList);



	}

	public SearchResultsPage() {
		PageFactory.initElements(driver, this);
		implicitWaitForElement(searchForm);
	}

	public void performSearch (String searchTerm) {
		implicitWaitForElement();
		keywordsField.sendKeys(searchTerm);
		keywordsField.sendKeys(Keys.RETURN);
		//searchButton.click();
	}



}
