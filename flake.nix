{
  description = "A Nix-flake-based Clojure development environment";

  inputs.nixpkgs.url = "github:nixos/nixpkgs/nixos-24.05";

  outputs = { self, nixpkgs }:

    let
      javaVersion = 21;
      overlays = [
        (final: prev: rec {
          jdk = prev."jdk${toString javaVersion}";
          clojure = prev.clojure.override { inherit jdk; };
        })
      ];
      supportedSystems = [
        "x86_64-linux"
        "aarch64-linux"
        "x86_64-darwin"
        "aarch64-darwin"
      ];
      forEachSupportedSystem = f: nixpkgs.lib.genAttrs supportedSystems (system: f {
        pkgs = import nixpkgs { inherit overlays system; };
      });
    in
      {
        devShells = forEachSupportedSystem ({ pkgs }: {
          default = pkgs.mkShell {
            packages = with pkgs; [
              jdk
              clojure-lsp
              clojure
              babashka
            ];
            LOCALE_ARCHIVE = "${pkgs.glibcLocales}/lib/locale/locale-archive";
          };
        });
      };
  nixConfig.bash-prompt = "(nix) \\w \\$ ";
}
