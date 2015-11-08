package com.mycompany.blue;

import com.mycompany.model.HelthCard;
import com.mycompany.model.Index;
import com.mycompany.model.User;
import domain.DAO;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users")
public class Test {
    Wraper wraper = new Wraper();
    DAO dao = new DAO();
    
    @GET
    @Path("/")
    public String getAll() {
        return wraper.listReply(dao.list());
    }
    
    @GET
    @Path("/{id}")
    public String getOne(@PathParam("id") int id) {
        return wraper.reply(dao.user(id));
    }
    
    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces(MediaType.TEXT_PLAIN)
    public String createUser(User user) {
        try {
            User newUser = new User(0,user.getUsername(),user.getPassword(),user.getEmail(),user.getFirstname(),user.getSecondname(),
            new byte[0], 1);
            dao.create(newUser);
        } catch(Exception e){
            return "fail";
        }
        return "success";
    }
    
    @POST
    @Path("/login")
    @Consumes("application/json")
    public String login(User user){
        User newUser = new User();
        newUser = dao.checkUsernamePassword(user.getUsername(), user.getPassword());
        if (newUser != null)
            return wraper.reply(newUser);
        else
            return "Username or password are not found";
    }
    
    @GET
    @Path("/card/{id}")
    public String card(@PathParam("id") int id) {
        HelthCard card = dao.card(id);
        return wraper.reply(card);
    }
    
    @POST
    @Path("/indexes")
    @Consumes("application/json")
    public String receiveData(Index index){
        try{
            dao.write(index.getIndexType(), index.getValue(), index.getUser().getId());
        } catch(Exception e){
            return "fail";
        }
        return "success";
    }
    
    @GET
    @Path("/inst/{id}")
    public String getInstructions(@PathParam("id") int id){
        return wraper.listReply(dao.getInstruct(id));
    }
    
    @GET
    @Path("/ind/{id}/{type}")
    public String ind(@PathParam("id") int id, @PathParam("type") int type){
        return wraper.reply(dao.readIndex(id,type));
    }
}
