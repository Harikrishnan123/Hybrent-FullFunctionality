package funcation_PageObject;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class Chat extends ApplicationKeyword{
    
	public static void VerifyChatPage()
    {
    	waitForElementToDisplay(OR.Chat, 60);
    	clickOn(OR.Chat);
    	waitForElementToDisplay(OR.Chat_Customerservice_txt, 60);
    	verifyElementText(OR.Chat_Customerservice_txt, "Customer Service");
        verifyElement(OR.Chat_input);
        verifyElement(OR.Chat_SendBtn);
        verifyElement(OR.Chat_close);
        verifyElement(OR.Chat_minimize);
        getAttributeValue(OR.Chat_input, "placeholder");
        chatFunction();
    }
	public static void chatFunction()
	{
		String chatMessage = "Testing";
		typeIn(OR.Chat_input, chatMessage);
		
		
	}

}
