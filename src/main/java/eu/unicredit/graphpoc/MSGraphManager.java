package eu.unicredit.graphpoc;

//import com.azure.identity.ClientSecretCredential;
//import com.azure.identity.ClientSecretCredentialBuilder;
//import com.azure.identity.UsernamePasswordCredential;
//import com.azure.identity.UsernamePasswordCredentialBuilder;
//import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
//import com.microsoft.graph.core.IBaseClient;
//import com.microsoft.graph.models.Drive;
//import com.microsoft.graph.models.User;
//import com.microsoft.graph.requests.GraphServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MSGraphManager {

    private final static String clientId = "dc501bc7-9370-46d3-aeb2-f75e7c7787cd";
    private final static String tenantId = "eaa077b8-33d5-4a08-ae32-b299a1649b80";
    private final static String clientSecret = "0Ou_5A9rHGym_zXu_23-G2W5-STCrx2tZd";

    private final static String username = "cmauri@ucsblink.onmicrosoft.com";
    private final static String password = "";

//    private final GraphServiceClient graphClient;
//    private final User me;

    public MSGraphManager() {

        /*
        final UsernamePasswordCredential credential = new UsernamePasswordCredentialBuilder()
                .clientId(clientId)
                .username(username)
                .password(password)
                .build();

        */
        /*
        final ClientSecretCredential credential = new ClientSecretCredentialBuilder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .tenantId(tenantId)
                .build();



        List<String> scopes = new ArrayList<>();
        scopes.add("https://graph.microsoft.com/.default");
        final TokenCredentialAuthProvider tokenCredentialAuthProvider = new TokenCredentialAuthProvider(scopes, credential);

        graphClient =
                GraphServiceClient
                        .builder()
                        .authenticationProvider(tokenCredentialAuthProvider)
                        .buildClient();

        IBaseClient<?> him = graphClient.users().getClient();
        log.info("Him is: {}", him);

        final Drive result = graphClient.me()
                .drive()
                .buildRequest()
                .get();
        log.info("Found Drive {}" + result.id);

        me = graphClient.me().buildRequest().get();
        log.info("Me is: {}", me);*/
    }

    List<String> getAppointments() {
//        final Drive result = graphClient.me()
//                .drive()
//                .buildRequest()
//                .get();
//        log.info("Found Drive {}" + result.id);

        List<String> ret = new ArrayList<>();
        ret.add("a");
        ret.add("b");
        return ret;
    }
}
