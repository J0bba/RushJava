package web;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/api")
public class API extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return getRestResourceClasses();
    }
    private Set<Class<?>> getRestResourceClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(APIService.class);
        return resources;
    }
}
