package com.testCase;
import com.page.LoginPage;
import com.setup.BaseTest;

import org.testng.annotations.Test;

public class FbLoginTest extends BaseTest {

    @Test(enabled = true)
    public void loginUnsuccessfulTest() {
        LoginPage lp = new LoginPage(getDriver());
        lp.loginUnsuccessful();
    }

}

