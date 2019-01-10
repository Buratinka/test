package app.model;

public enum Role
{
    UNREGISTERED(1),
    REGISTERED(2),
    ADMIN(3);

    private int accessLevel;

    Role(int accessLevel)
    {
        this.accessLevel = accessLevel;
    }

    public int getAccessLevel()
    {
        return accessLevel;
    }
}
