package AccountingSoftware;

import AccountingSoftware.service.AuthService;
import AccountingSoftware.service.AuthServiceImpl;
import AccountingSoftware.service.UserInteractionService;
import AccountingSoftware.service.UserInteractionServiceImpl;


public class MainClass {
    public static void main(String[] args) {
        AuthService authService = new AuthServiceImpl();
        authService.authenticate();
        UserInteractionService userInteractionService = new UserInteractionServiceImpl();
        userInteractionService.initInteraction();
            }
        }

