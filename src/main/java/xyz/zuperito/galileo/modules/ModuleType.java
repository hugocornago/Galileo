package xyz.zuperito.galileo.modules;

public enum ModuleType {
    TEST("Testing"),
    PLAYER("categories.player");
    final String name;
    ModuleType(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }
}
