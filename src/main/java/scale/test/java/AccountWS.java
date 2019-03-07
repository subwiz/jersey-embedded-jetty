package scale.test.java;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/account")
public class AccountWS {
    private int i;

    private AccountModel getRandomAccount() {
        AccountModel out = new AccountModel();
        out.setOrgName(i + " Name");
        out.setOrgShortName(i + "-nme");
        AddressModel addr = new AddressModel();
        addr.setCity("Chennai");
        addr.setState("Tamil Nadu");
        addr.setCountry("India");
        addr.setDoorNo("256");
        addr.setLine1("Line one of address");
        addr.setLine2("Line two of address");
        out.setAddress(addr);
        return out;
    }

    @GET
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<AccountModel> getAccounts() {
        List<AccountModel> out = new ArrayList<>();
        for(int i=0; i<50; i++) {
            this.i = i;
            out.add(getRandomAccount());
        }
        return out;
    }
}
