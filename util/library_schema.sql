-- SQLite schema for Smart Library System

CREATE TABLE IF NOT EXISTS members (
    id TEXT PRIMARY KEY,
    section TEXT NOT NULL,
    authorized BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS librarians (
    id TEXT PRIMARY KEY,
    section TEXT NOT NULL,
    authorized BOOLEAN NOT NULL,
    shift TEXT NOT NULL
);
