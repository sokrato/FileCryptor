(defproject io.github.sokrato/crypto "0.1.0-SNAPSHOT"
  :description "Tests of Clojure test-framework."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [org.encryptor4j/encryptor4j "0.1.2"]]
  :source-paths      ["src/main/clojure"]
  :java-source-paths ["src/main/java"]
  :test-paths        ["src/test/clojure"]
  :java-test-paths   ["src/test/java"]
  :main simplex.crypto
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}}
  )