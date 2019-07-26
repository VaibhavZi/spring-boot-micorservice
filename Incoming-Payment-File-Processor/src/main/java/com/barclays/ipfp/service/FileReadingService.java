package com.barclays.ipfp.service;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static java.nio.file.StandardWatchEventKinds.*;

import java.io.IOException;

@Service
public class FileReadingService {

	WatchService watcher;

	private static final Logger log = LoggerFactory.getLogger(FileReadingService.class);

	Path dir;
	WatchKey key;

	public void checkFilesInDir() {
		dir = Paths.get("C:\\Users\\10640143\\Desktop\\SpringBoot\\Incoming-Payment-File-Processor\\Files\\");

		try {
			watcher = FileSystems.getDefault().newWatchService();
			key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
		} catch (IOException x) {
			System.err.println(x);
			log.error(x.getMessage().toString());
		}

		for (;;) {
			try {
				key = watcher.take();
			} catch (InterruptedException x) {
				return;
			}

			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent.Kind<?> kind = event.kind();

				// This key is registered only
				// for ENTRY_CREATE events,
				// but an OVERFLOW event can
				// occur regardless if events
				// are lost or discarded.
				if (kind == OVERFLOW) {
					continue;
				}

				// The filename is the
				// context of the event.
				@SuppressWarnings("unchecked")
				WatchEvent<Path> ev = (WatchEvent<Path>) event;
				Path filename = ev.context();

				// Verify that the new
				// file is a text file.
				try {
					// Resolve the filename against the directory.
					// If the filename is "test" and the directory is "foo",
					// the resolved name is "test/foo".
					Path child = dir.resolve(filename);
					if (!Files.probeContentType(child).equals("json")) {
						System.err.format("New file '%s'" + " is not a plain text file.%n", filename);
						continue;
					}
				} catch (IOException x) {
					System.err.println(x);
					continue;
				}

				// Email the file to the
				// specified email alias.
				System.out.format("Emailing file %s%n", filename);
				// Details left to reader....
			}

			// Reset the key -- this step is critical if you want to
			// receive further watch events. If the key is no longer valid,
			// the directory is inaccessible so exit the loop.
			boolean valid = key.reset();
			if (!valid) {
				break;
			}
		}
	}
}
