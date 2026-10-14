package dev.tace.cli;

import dev.tace.model.Permission;
import dev.tace.service.TaceService;
import dev.tace.store.ValkeyStore;
import picocli.CommandLine;
import picocli.CommandLine.*;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.concurrent.Callable;

// ===== Sec 1: Root command - top-level CLI setup and service factory =====
@Command(name="tace", mixinStandardHelpOptions=true, version="TACE 1.0.0",
 description="Temporal Access-Control Engine CLI",
 subcommands={TaceCommand.User.class, TaceCommand.Role.class, TaceCommand.PermissionCmd.class,
              TaceCommand.Authorize.class, TaceCommand.Audit.class})
public class TaceCommand implements Runnable {
    @Override public void run() { new CommandLine(this).usage(System.out); }
    static TaceService service() { return new TaceService(new ValkeyStore()); }
