/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.typeslibrary.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.parts.NativeTypePropertiesEditionPart;
import org.obeonetwork.dsl.typeslibrary.parts.TypeslibraryViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class NativeTypePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for mapsTo EObjectFlatComboViewer
	 */
	private	EObjectFlatComboSettings mapsToSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public NativeTypePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject nativeType, String editing_mode) {
		super(editingContext, nativeType, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = TypeslibraryViewsRepository.class;
		partKey = TypeslibraryViewsRepository.NativeType.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			final NativeType nativeType = (NativeType)elt;
			final NativeTypePropertiesEditionPart basePart = (NativeTypePropertiesEditionPart)editingPart;
			// init values
			if (nativeType.getName() != null && isAccessible(TypeslibraryViewsRepository.NativeType.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), nativeType.getName()));
			
			if (isAccessible(TypeslibraryViewsRepository.NativeType.Properties.spec)) {
				basePart.initSpec((EEnum) TypesLibraryPackage.eINSTANCE.getNativeType_Spec().getEType(), nativeType.getSpec());
			}
			if (isAccessible(TypeslibraryViewsRepository.NativeType.Properties.mapsTo)) {
				// init part
				mapsToSettings = new EObjectFlatComboSettings(nativeType, TypesLibraryPackage.eINSTANCE.getNativeType_MapsTo());
				basePart.initMapsTo(mapsToSettings);
				// set the button mode
				basePart.setMapsToButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			
			basePart.addFilterToMapsTo(new ViewerFilter() {
			
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return (element instanceof String && element.equals("")) || (element instanceof NativeType); //$NON-NLS-1$ 
				}
			
			});
			// Start of user code for additional businessfilters for mapsTo
			// End of user code
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}






	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	protected EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == TypeslibraryViewsRepository.NativeType.Properties.name) {
			return TypesLibraryPackage.eINSTANCE.getNativeType_Name();
		}
		if (editorKey == TypeslibraryViewsRepository.NativeType.Properties.spec) {
			return TypesLibraryPackage.eINSTANCE.getNativeType_Spec();
		}
		if (editorKey == TypeslibraryViewsRepository.NativeType.Properties.mapsTo) {
			return TypesLibraryPackage.eINSTANCE.getNativeType_MapsTo();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		NativeType nativeType = (NativeType)semanticObject;
		if (TypeslibraryViewsRepository.NativeType.Properties.name == event.getAffectedEditor()) {
			nativeType.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (TypeslibraryViewsRepository.NativeType.Properties.spec == event.getAffectedEditor()) {
			nativeType.setSpec((NativeTypeKind)event.getNewValue());
		}
		if (TypeslibraryViewsRepository.NativeType.Properties.mapsTo == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				mapsToSettings.setToReference((NativeType)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				NativeType eObject = TypesLibraryFactory.eINSTANCE.createNativeType();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				mapsToSettings.setToReference(eObject);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {	
			NativeTypePropertiesEditionPart basePart = (NativeTypePropertiesEditionPart)editingPart;
			if (TypesLibraryPackage.eINSTANCE.getNativeType_Name().equals(msg.getFeature()) && basePart != null && isAccessible(TypeslibraryViewsRepository.NativeType.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (TypesLibraryPackage.eINSTANCE.getNativeType_Spec().equals(msg.getFeature()) && isAccessible(TypeslibraryViewsRepository.NativeType.Properties.spec))
				basePart.setSpec((Enumerator)msg.getNewValue());
			
			if (TypesLibraryPackage.eINSTANCE.getNativeType_MapsTo().equals(msg.getFeature()) && basePart != null && isAccessible(TypeslibraryViewsRepository.NativeType.Properties.mapsTo))
				basePart.setMapsTo((EObject)msg.getNewValue());
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (TypeslibraryViewsRepository.NativeType.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EcoreUtil.createFromString(TypesLibraryPackage.eINSTANCE.getNativeType_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getNativeType_Name().getEAttributeType(), newValue);
				}
				if (TypeslibraryViewsRepository.NativeType.Properties.spec == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EcoreUtil.createFromString(TypesLibraryPackage.eINSTANCE.getNativeType_Spec().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getNativeType_Spec().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

}
