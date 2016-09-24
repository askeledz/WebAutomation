package com.askeledz.test.envygram;

import org.testng.annotations.Test;

import java.io.IOException;

public class JoinEnvyGramTest extends EnvyGramTestBase {

    @Test(priority = 1)
    public void SignInTest() throws InterruptedException, IOException {
        SignIn();
    }

    @Test(priority = 2)
    public void CreateNewPostTest() throws InterruptedException, IOException {

        SignIn();
        CreateNewPost();

    }

    @Test(priority = 3)
    public void CancelNewPostTest() throws InterruptedException, IOException {

        SignIn();
        CancelNewPost();
    }

    @Test(priority = 4)
    public void SearchPostsTest() throws InterruptedException, IOException {

        SignIn();
        SearchPosts();

    }

    @Test(priority = 5)
    public void NotificationsCheckTest() throws InterruptedException, IOException {

        SignIn();
        NotificationsCheck();
    }

    @Test(priority = 6)
    public void EditProfileTest() throws InterruptedException, IOException {

        SignIn();
        EditProfile();

    }

    @Test(priority = 7)
    public void CancelEditProfileTest() throws InterruptedException, IOException {

        SignIn();
        CancelEditProfile();

    }

    public void LogOutTest() throws InterruptedException, IOException {

        SignIn();
        LogOut();
    }
}