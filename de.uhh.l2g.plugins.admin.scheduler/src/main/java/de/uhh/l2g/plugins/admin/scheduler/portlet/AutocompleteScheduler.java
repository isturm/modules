package de.uhh.l2g.plugins.admin.scheduler.portlet;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseSchedulerEntryMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;

import de.uhh.l2g.plugins.util.AutocompleteManager;

@Component(
		immediate = true,
		service = AutocompleteScheduler.class
)

public class AutocompleteScheduler extends BaseSchedulerEntryMessageListener {
	  /**
	   * doReceive: This is where the magic happens, this is where you want to do the work for
	   * the scheduled job.
	   * @param message This is the message object tied to the job.  If you stored data with the
	   *                job, the message will contain that data.   
	   * @throws Exception In case there is some sort of error processing the task.
	   */
	  @Override
	  protected void doReceive(Message message) throws Exception {
		if (_log.isInfoEnabled()) {
			_log.info("Received message on schedule: " + message);
			// uncoment for further debug messages
			// super.receive(message);
			_log.info("Autocomplete Scheduler running " + message.getValues().get(SchedulerEngine.JOB_NAME).toString() + "...");
			// Do Job
			try {
				AutocompleteManager.generateAutocompleteResults();
				_log.info("Autocomplete Scheduler finished.");
			} catch (SystemException e) {
				_log.info("Autocomplete Scheduler failed.");
			}
		}	    
	  }
	  //
	  @Activate
	  @Modified
		protected void activate() {
			schedulerEntryImpl.setTrigger(TriggerFactoryUtil.createTrigger(getEventListenerClass(), getEventListenerClass(), 15, TimeUnit.MINUTE));
			_schedulerEngineHelper.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
		}

		@Deactivate
		protected void deactivate() {
			_schedulerEngineHelper.unregister(this);
		}

		@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
		protected void setModuleServiceLifecycle(
			ModuleServiceLifecycle moduleServiceLifecycle) {
		}
		
		@Reference(unbind = "-")
		protected void setSchedulerEngineHelper(SchedulerEngineHelper schedulerEngineHelper) {

			_schedulerEngineHelper = schedulerEngineHelper;
		}

		@Reference(unbind = "-")
		protected void setTriggerFactory(TriggerFactory triggerFactory) {
		}

		private SchedulerEngineHelper _schedulerEngineHelper;

	  private static final Log _log = LogFactoryUtil.getLog(AutocompleteManager.class);
}
