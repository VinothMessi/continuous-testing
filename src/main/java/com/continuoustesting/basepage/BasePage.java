package com.continuoustesting.basepage;

import com.continuoustesting.helpers.ElementActions;
import com.continuoustesting.helpers.WebActions;
import org.springframework.beans.factory.annotation.Autowired;

public
abstract
class BasePage {
    @Autowired
    protected
    WebActions webBrowser;

    @Autowired
    protected
    ElementActions webElement;
}