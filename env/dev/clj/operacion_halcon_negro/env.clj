(ns operacion-halcon-negro.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [operacion-halcon-negro.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[operacion-halcon-negro started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[operacion-halcon-negro has shut down successfully]=-"))
   :middleware wrap-dev})
