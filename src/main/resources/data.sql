INSERT INTO roles (name, created_at, updated_at) VALUES ('ADMIN', NOW(), NOW()) ON CONFLICT (name) DO NOTHING;
INSERT INTO roles (name, created_at, updated_at) VALUES ('MEMBER', NOW(), NOW()) ON CONFLICT (name) DO NOTHING;
