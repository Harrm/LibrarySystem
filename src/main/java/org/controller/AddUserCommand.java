package org.controller;

import org.items.User;
import org.storage.ItemSerializer;
import org.storage.LibraryStorage;
import org.storage.Storage;
import org.storage.resources.Resource;

/**
 * This command adds a user to a storage
 * @see Command
 */
public class AddUserCommand implements Command {

    public AddUserCommand(User newUser, User executor) {
        this.newUser = newUser;
        this.executor = executor;
    }

    @Override
    public Command.Result execute(LibraryStorage storage) {

        if(newUser.getType().equals("Admin")) {
            return Result.failure("There can be only one admin");
        }
        if(newUser.getType().equals("Librarian") && !executor.getType().equals("Admin")) {
            return Result.failure("A librarian can be added by the admin only");
        }
        if(executor.getType().equals("Librarian") && !executor.hasPrivilege(User.Privilege.Addition)) {
            return Result.failure("Access denied; the 'Addition' privilege is required");
        }
        try {
            storage.add(Resource.User, ItemSerializer.serialize(newUser));
            return Result.Success;

        } catch (Storage.QueryExecutionError e) {
            return Result.failure(e.getMessage()+e.getCause().getMessage());
        }
    }

    private final User executor;
    private final User newUser;
}
