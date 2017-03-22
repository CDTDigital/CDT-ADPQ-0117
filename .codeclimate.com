engines:
  checkstyle:
    enabled: true
    channel: "beta"
  eslint:
    enabled: true
  csslint:
    enabled: true
  duplication:
    enabled: true
    config:
      languages:
      - javascript

ratings:
  paths:
  - "src/main/java/**"


