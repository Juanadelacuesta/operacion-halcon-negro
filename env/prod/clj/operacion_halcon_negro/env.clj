(ns operacion-halcon-negro.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[operacion-halcon-negro started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[operacion-halcon-negro has shut down successfully]=-"))
   :middleware identity})
