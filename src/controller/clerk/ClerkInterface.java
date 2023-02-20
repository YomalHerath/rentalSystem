package controller.clerk;

import model.Clerk;

import java.util.List;

public interface ClerkInterface {
    public void save(Clerk clerk);
    public void update(Clerk clerk);
    public Clerk get (int clerkId);
    public List<Clerk> list();
}
