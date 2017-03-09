(ns operacion-halcon-negro.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [operacion-halcon-negro.layout :refer [error-page]]
            [operacion-halcon-negro.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [operacion-halcon-negro.env :refer [defaults]]
            [mount.core :as mount]
            [operacion-halcon-negro.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    (-> #'home-routes
        (wrap-routes middleware/wrap-csrf)
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
