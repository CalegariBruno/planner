ALTER TABLE participant ADD CONSTRAINT fk_trip_id FOREIGN KEY (trip_id) REFERENCES trips(id) ON DELETE CASCADE