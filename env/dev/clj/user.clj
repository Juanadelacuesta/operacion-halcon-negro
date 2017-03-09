(ns user
  (:require [mount.core :as mount]
            operacion-halcon-negro.core))

(defn start []
  (mount/start-without #'operacion-halcon-negro.core/http-server
                       #'operacion-halcon-negro.core/repl-server))

(defn stop []
  (mount/stop-except #'operacion-halcon-negro.core/http-server
                     #'operacion-halcon-negro.core/repl-server))

(defn restart []
  (stop)
  (start))


