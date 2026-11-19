import { useState } from "react";
import '../../../styles/menu.css'; // Vérifiez le chemin relatif selon l'emplacement exact

const menuItems = [
  { label: "Favoris", href: "/encyclopedie"},
  {
    label: "Météorologie",
    submenu: [
      { label: "Phénomènes & Nuages", href: "#" },
      { label: "Messages & Bulletins", href: "#" },
      { label: "Altimétrie & Pression", href: "#" },
      { label: "Cartes & Prévisions", href: "#" },
    ],
  },
  {
    label: "Aérodromes",
    submenu: [
      { label: "Aménagements & Pistes", href: "#" },
      { label: "Balisage & Signalisation", href: "#" },
      { label: "Services & Informations", href: "#" },
    ],
  },
  {
    label: "Réglementation",
    submenu: [
      { label: "Règles de l'air", href: "#" },
      { label: "Espaces aériens", href: "#" },
      { label: "Communications & Phraséologie", href: "#" },
      { label: "Préparation & Plans de vol", href: "#" },
    ],
  },
  {
    label: "Vol à Vue (VFR)",
    submenu: [
      { label: "Conditions & Réglementation VFR", href: "#" },
      { label: "Navigation & Cartographie", href: "#" },
      { label: "Procédures d'aérodrome", href: "#" },
      { label: "Vols particuliers (Nuit / Spécial)", href: "#" },
    ],
  },
  {
    label: "Vol aux Instruments (IFR)",
    submenu: [
      { label: "Conditions & Réglementation IFR", href: "#" },
      { label: "Radionavigation & Moyens", href: "#" },
      { label: "Procédures de départ & d'arrivée", href: "#" },
      { label: "Procédures d'approche & Attente", href: "#" },
    ],
  },
  {
    label: "Mémos",
    submenu: [
      { label: "Aide-mémoires opérationnels", href: "#" },
      { label: "Fiches de révision IVAO", href: "#" },
    ],
  },
  {
    label: "Gérer mes fiches",
    submenu: [
      { label: "Importer / Exporter", href: "#" },
      { label: "Mes créations", href: "#" },
      { label: "Fiches masquées", href: "#" },
      { label: "Signalements", href: "#" },
    ],
  },
];

export default function Menu() {
  const [openIndex, setOpenIndex] = useState(null);

  const toggleSubmenu = (index) => {
    setOpenIndex((prev) => (prev === index ? null : index));
  };

  return (
    <nav className="navbar" aria-label="Navigation principale">
      <ul className="menu">
        {menuItems.map((item, index) => {
          const hasSubmenu = Boolean(item.submenu);
          const isOpen = openIndex === index;

          return (
            <li key={item.label} className="menu-item">
              {hasSubmenu ? (
                <>
                  <button
                    type="button"
                    className="menu-button"
                    aria-expanded={isOpen}
                    onClick={() => toggleSubmenu(index)}
                  >
                    <span>{item.label}</span>
                    <span>{isOpen ? "▴" : "▾"}</span>
                  </button>

                  {isOpen && (
                    <ul className="submenu">
                      {item.submenu.map((sub) => (
                        <li key={sub.label} className="submenu-item">
                          <a href={sub.href}>{sub.label}</a>
                        </li>
                      ))}
                    </ul>
                  )}
                </>
              ) : (
                <a href={item.href} className="menu-link">
                  {item.label}
                </a>
              )}
            </li>
          );
        })}
      </ul>
    </nav>
  );
}