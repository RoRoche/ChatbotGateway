package fr.guddy.recastclient.bot;

public interface Reply<C> {
    String getType();

    C getContent();
}
